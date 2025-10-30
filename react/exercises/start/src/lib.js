export const productFilters = {
  catFilter(category) {
    // Remove the category that we don't want.
    return (product) =>
      product.category.toLowerCase() !== category.toLowerCase();
  },
  isStockedFilter() {
    return (product) => product.qty > 0;
  },
};
