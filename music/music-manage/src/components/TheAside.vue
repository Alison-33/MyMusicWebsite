<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#334256"
            text-color="#ffffff"
            active-text-color="#20a0ff"
            router
        >
            <template v-for="item in items">
                <template>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        {{item.title}}
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from "../assets/js/bus"
export default {
    data(){
        return{
            collapse: false,
            items: [
                {
                    icon: 'el-icon-document',
                    index: 'Info',
                    title: 'Info'
                },
                {
                    icon: 'el-icon-document',
                    index: 'Consumer',
                    title: 'User'
                },
                {
                    icon: 'el-icon-document',
                    index: 'Singer',
                    title: 'Singer'
                },
                {
                    icon: 'el-icon-document',
                    index: 'SongList',
                    title: 'Song list'
                },
            ]
        }
    },
    computed:{
        onRoutes(){
            return this.$route.path.replace('/','');
        }
    },
    created(){
        // Use bus to communicate between elements, and to control the collapse of sidebar
        // from header
        bus.$on('collapse', msg =>{
            this.collapse = msg
        })
    }
}
</script>


<style scoped>
.sidebar{
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    background-color: #334256;
    overflow-y: scroll;
}

.sidebar::-webkit-scrollbar{
    width: 0;
}

.sidebar-el-menu:not(.el-menu--collapse){
    width: 150px;
}
.el-menu--collapse{
    width: 48px;
}
.sidebar >ul{
    height: 100%;
}

</style>
