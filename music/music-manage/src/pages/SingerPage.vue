<template>
    <div class="table">
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" size="mini" @click="centerDialogVisible = true">Add singer</el-button>
            </div>
        </div>
        <el-table size="mini" border style="width:100%" height="500px" :data="tableData">
            <el-table-column label="Singer image" width="110" align="center">
                <template slot-scope="scope">
                    <div class="singer-img">
                        <img :src="getUrl(scope.row.pic)" style="width:100%" />
                    </div>
                </template>
            </el-table-column>
            
        </el-table>
        <el-dialog title="Add singer" :visible.sync="centerDialogVisible" width="600px" center>
            <el-form :model="registerForm" ref="registerForm" label-width="80px">
                <el-form-item prop="name" label="Name" size="mini">
                    <el-input v-model="registerForm.name" placeholder="Singer name"></el-input>
                </el-form-item>
                <el-form-item label="Gender" size="mini" >
                    <el-radio-group v-model="registerForm.gender" class="radioButtons">
                        <el-radio label="0">Female</el-radio>
                        <el-radio label="1">Male</el-radio>
                        <el-radio label="2">Group</el-radio>
                        <el-radio label="3">Other</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item prop="birthday" label="Birthday" size="mini">
                    <el-date-picker type="date" placeholder="Select birth date" v-model="registerForm.birthday"></el-date-picker>
                </el-form-item>
                <el-form-item prop="location" label="Location" size="mini">
                    <el-input v-model="registerForm.location" placeholder="Singer location"></el-input>
                </el-form-item>
                <el-form-item prop="intro" label="Intro" size="mini">
                    <el-input v-model="registerForm.intro" placeholder="Singer introduction" type="textarea"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="centerDialogVisible = false">Cancel</el-button>
                <el-button size="mini" @click="addSinger">Confirm</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import {getAllSinger, setSinger} from '../api/index';
import{mixin} from '../mixins';
export default {
    mixins:[mixin],
    data(){
        return{
            centerDialogVisible: false,
            registerForm:{ 
                name: '',
                gender: '',
                birthday: '',
                location: '',
                intro:''
            },
            tableData: []
        }
    },

    created(){
        this.getData();
    },

    methods:{

        getData(){
            this.tableData = [];
            getAllSinger().then(res=>{
                this.tableData = res;
            })
        },

        addSinger(){
            let d = this.registerForm.birthday;
            let datetime = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
            let params = new URLSearchParams();
            params.append('name',this.registerForm.name);
            params.append('gender',this.registerForm.gender);
            params.append('pic','/img/singerPic/headshot-placeholder.png');
            params.append('birthday',datetime);
            params.append('location',this.registerForm.location);
            params.append('intro',this.registerForm.intro);

            setSinger(params)
            .then(res => {
                if(res.code == 1){
                    this.notify("Added successfully", "success");
                }
                else{
                    this.notify("Failed to add", "error");
                }
            })
            .catch(err => {
                console.log(err);
            });
            this.centerDialogVisible = false;
        }
    },
}
</script>

<style scoped>
    .handle-box{
        margin-bottom: 20px;
    }
    .radioButtons {
        display: inline-flex;
    }
    .singer-img{
        width: 100%;
        height: 80px;
        border-radius: 5px;
        margin-bottom: 5px;
        overflow: hidden;
    }

</style>

