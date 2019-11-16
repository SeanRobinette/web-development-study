import React from 'react';

export class ProductCategoryRow extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        const name = this.props.name;
        return(
            <tr>
                <th colSpan="2">{name}</th>
            </tr>
        );
    }
}