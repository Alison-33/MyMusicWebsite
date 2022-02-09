import {get, post} from "./http";

// to check if the admin has logged in successfully
export const getLoginStatus = (params) => post(`admin/login/status`, params);

// get all singers
export const getAllSinger = () => get(`singer/allSinger`);

// add singer
export const setSinger = (params) => post(`singer/add`, params);