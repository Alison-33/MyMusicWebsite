import axios from 'axios';
import VueRouter from 'vue-router';
axios.defaults.timeout = 5000; // timeout after 5 sec.
axios.defaults.withCredentials = true; // allowing cross-domain

// Content-type 
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

// base url
axios.defaults.baseURL = "http://localhost:8888";

// interceptors
axios.interceptors.response.use(
    response => {
        // if the status in response is 200, then visit success
        if(response.status == 200){
            return Promise.resolve(response);
        }
        else{
            return Promise.reject(response);
        }
    },

    // if there is a error status 
    error =>{
        if(error.response.status){
            switch(error.response.status){
                case 401: // not logged in
                    VueRouter.replace({
                        path:'/',
                        query:{
                            redirect: VueRouter.currentRoute.fullPath
                        }
                    });
                    break;

                case 404: // failed to locate the address
                    break;
            }
            return Promise.reject(error.response);
        }
    }
);

/**
 * encapsupated get method
 */
// the url here is a relative path.
export function get(url, params={}){
    return new Promise((resolve, reject) => {
        axios.get(url, {params:params})
        .then(response => {
            resolve(response.data);
        }) // in case of resolve
        .catch(err => {
            reject(err);
        }) // in case of reject
    });
}


/**
 * encapsulated post method
 */
 export function post(url, data={}){
    return new Promise((resolve, reject) => {
        axios.post(url, data)
        .then(response => {
            resolve(response.data);
        }) // in case of resolve
        .catch(err => {
            reject(err);
        }) // in case of reject
    });
}