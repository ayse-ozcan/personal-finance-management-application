// import jwt_decode from "jwt-decode";
export const setUserToken = (token) => {
  localStorage.setItem("token", token);
};

export const getUserTokenFromStorage = () => {
  return localStorage.getItem("token");
};
// export const getDecodedUserToken = () => {
//   const token = getUserTokenFromStorage();
//   const decodedToken = jwt_decode(token);
//   return decodedToken;
// };
export const removeUserTokenFromStorage = () => {
  localStorage.removeItem("token");
};
