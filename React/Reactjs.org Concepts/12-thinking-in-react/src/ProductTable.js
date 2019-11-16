import React from 'react';
import { ProductRow } from './ProductRow';
import { ProductCategoryRow } from './ProductCategoryRow';

export class ProductTable extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        const products = this.props.products;
        const searchText = this.props.searchText;
        const inStockOnly = this.props.inStockOnly;
        let lastCategory = '';

        // Build the list of rows
        const rows = [];
        products.forEach(product => {
            // Skip if there's a filter and the product doesn't match it
            if(searchText !== '') {
                if(!product.name.includes(searchText)) {
                    return;
                }
            }
            // Also skip if we're only showing in-stock items and it's out of stock
            if(inStockOnly && !product.stocked) {
                return;
            }
            // Add the category row if we're on a new category
            if(product.category !== lastCategory) {
                rows.push(
                    <ProductCategoryRow name={product.category} />
                );
            }
            // Update the category and add the product row
            lastCategory = product.category;
            rows.push(
                <ProductRow product={product}/>
            );
        });
        return (
            <table style={{display: "inline-table"}}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {rows}
                </tbody>
            </table>
        );
    }
}