import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { Field, reduxForm } from "redux-form";
import { fetchTask, deleteTask, updateTask } from "../actions";
import moment from "moment";

class TasksShow extends Component {
  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.fetchTask(id);
  }

  onDeleteClick() {
    const { id } = this.props.match.params;

    this.props.deleteTask(id, () => {
      this.props.history.push("/");
    });
  }


  onUpdateClick(values) {

    values.active = true;

    this.props.updateTask(values, () => {
      this.props.history.push("/");
  });
  }


  renderField(field) {
    const { meta: { touched, error } } = field;
    const className = `form-group ${touched && error ? "has-danger" : ""}`;



    return (
      <div className={className}>
        <label>{field.label}</label>
        <input className="form-control" type="text" {...field.input}  />
        <div className="text-help">
          {touched ? error : ""}
        </div>
      </div>
    );
  }

  renderCheck(field) {
    const { meta: { touched, error } } = field;
    const className = `form-group ${touched && error ? "has-danger" : ""}`;
    console.log("LOG  :"+ JSON.stringify(field))
    const checked = field.defaultValue
    return (
      <div className={className}>
        <label>{field.label}</label>
          <input className="form-control" type="checkbox" {...field.input} checked />
          
        <div className="text-help">
          {touched ? error : ""}
        </div>
      </div>
    );

    
  }

  render() {
   
    const { task,handleSubmit } = this.props;

    if (!task) {
      return <div>Loading...</div>;
    }

    return (
      <div>
        <Link to="/">Volver al Home</Link>




        <form onSubmit={handleSubmit(this.onUpdateClick.bind(this))}>
        <h3>ID = {task.id}  - Descripción = {task.description}  - Fecha = {moment(task.date).format('DD-MM-YYYY')}</h3>
        <Field
          label="Nueva Descripción"
          name="description"
          value={task.description}
          defaultValue={task.description}
          component={this.renderField}
          
        />
        <Field
          label="Nueva Fecha"
          name="date"
          value={task.date}
          defaultValue={task.date}
          component={this.renderField}
        
        />
        <Field
        type="checkbox"
          label="Active"
          name="active"
          value={task.active}
          defaultValue={task.active}
          component={this.renderCheck}
        />


         <br/>
        <button type="submit" className="btn btn-primary">Actualizar</button>

        <button
          className="btn btn-danger pull-xs-right"
          onClick={this.onDeleteClick.bind(this)}
        >
          Eliminar
        </button>
        
      </form>



        

      </div>
    );
  }
}


function validate(values) {

  const errors = {};

  // Validate the inputs from 'values'
  if (!values.description) {
    errors.title = "Ingrese una descripción";
  }
  if (!values.date) {
    errors.date = "Enter some date";
  }

  return errors;
}

function mapStateToProps({ tasks }, ownProps) {
  return { task: tasks[ownProps.match.params.id] };
}

export default reduxForm({
  validate,
  form: "PostsNewForm"
})(connect(mapStateToProps, { fetchTask: fetchTask, deleteTask: deleteTask, updateTask : updateTask })(TasksShow));
