import React from 'react';

export class ProductRow extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        const product = this.props.product;
        const name = product.stocked 
            ? <td>{product.name}</td>
            : <td><span style={{color:"red"}}>{product.name}</span></td>

        return (
            <tr>
                <td>{name}</td>
                <td>{product.price}</td>
            </tr>
        );
    }
}