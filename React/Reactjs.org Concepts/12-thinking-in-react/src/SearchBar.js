import React from 'react';

export class SearchBar extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        const searchText = this.props.searchText;
        const inStockOnly = this.props.inStockOnly;
        const onChange = this.props.onChange;

        return(
            <form>
                <input type="text" placeholder="Search..." value={searchText} 
                    name="searchText" onChange={onChange}/>
                <div>
                    <input type="checkbox" checked={inStockOnly} name="inStockOnly"
                        onChange={onChange}/>
                    &nbsp;
                    Only show products in stock
                </div>
            </form>
        );
    }
}