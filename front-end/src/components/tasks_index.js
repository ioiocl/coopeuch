import _ from "lodash";
import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { fetchTasks } from "../actions";
import moment from "moment";

class TasksIndex extends Component {
  componentDidMount() {
    this.props.fetchTasks();
  }

  renderTasks() {
    return _.map(this.props.tasks, task => {
      return (
        <li className="list-group-item" key={task.id}>
          <Link to={`/tasks/${task.id}`}>
            {task.description} - {moment(task.date).format('DD-MM-YYYY')}
          </Link>
        </li>
      );
    });
  }

  render() {
    return (
      <div>
        <div className="text-xs-right">
          <Link className="btn btn-primary" to="/tasks/new">
            Agregar una Tarea
          </Link>
        </div>
        <h3>Tareas</h3>
        <ul className="list-group">
          {this.renderTasks()}
        </ul>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { tasks: state.tasks };
}

export default connect(mapStateToProps, { fetchTasks: fetchTasks })(TasksIndex);
