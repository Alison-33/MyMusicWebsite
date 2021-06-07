import {get, post} from "./http";

// to check if the admin has logged in successfully
export const getLoginStatus = (params) => post(`admin/login/status`, params);