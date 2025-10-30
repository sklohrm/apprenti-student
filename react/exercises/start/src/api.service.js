import ky from "ky";

const BASE_URL = "http://localhost:3001/products";

const api = {
  index() {
    return ky.get(BASE_URL).json();
  },
};

export default api;
