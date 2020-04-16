import React, { Component } from "react";
import { Field, reduxForm } from "redux-form";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import { createTask } from "../actions";

class TasksNew extends Component {
  renderField(field) {
    const { meta: { touched, error } } = field;
    const className = `form-group ${touched && error ? "has-danger" : ""}`;

    return (
      <div className={className}>
        <label>{field.label}</label>
        <input className="form-control" type="text" {...field.input} />
        <div className="text-help">
          {touched ? error : ""}
        </div>
      </div>
    );
  }

  onSubmit(values) {
	values.active = true;
    this.props.createTask(values, () => {
      this.props.history.push("/");
    });
  }

  render() {
    const { handleSubmit } = this.props;

    return (
      <div>
<Link to="/">Volver al Home</Link><br/>


      <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
        <Field
          label="Descripcion"
          name="description"
          component={this.renderField}
        />
        <Field
          label="Fecha"
          name="date"
          component={this.renderField}
        />
        <label>Active <Field
        type="checkbox"
          label="Active"
          name="active"
          
          component="input"
        /></label>


         <br/>
        <button type="submit" className="btn btn-primary">Submit</button>
        <Link to="/" className="btn btn-danger">Cancel</Link>
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

export default reduxForm({
  validate,
  form: "PostsNewForm"
})(connect(null, { createTask: createTask })(TasksNew));
