import React from "react";
import "./Button.css";

export default class Button extends React.Component {
    handleclick = () => {
        this.props.clickHandler(this.props.name);
    };

    render() {
        const { orange, wide, name } = this.props;

        const className = `component-button ${orange ? "orange" : ""} ${wide ? "wide" : ""}`

        return (
            <div className={className.trim()}>
                <button onClick={this.handleclick}>{name}</button>
            </div>
        )
    }
}
