import React from 'react';
import { ProductTable } from './ProductTable';
import { SearchBar } from './SearchBar';

export class FilterableProductTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            searchText: 'ball',
            inStockOnly: true
        }
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(e) {
        const name = e.target.name;
        const value = e.target.type === 'checkbox' ? e.target.checked : e.target.value;

        this.setState({
            [name]: value
        });
    }
    render() {
        const products = this.props.products;
        const searchText = this.state.searchText;
        const inStockOnly = this.state.inStockOnly;

        return (
            <div>
                <SearchBar
                    searchText={searchText}
                    inStockOnly={inStockOnly}
                    onChange={this.handleChange}/>
                <ProductTable
                    products={products}
                    searchText={searchText}
                    inStockOnly={inStockOnly}
                    onChange={this.handleChange}/>
            </div>
        );
    }
}