export const mixin = {
    methods:{
        // notify information
        notify(title, type){
            this.$notify({
                title: title,
                type: type
            })
        },
        // Get absolute path from relative path
        getUrl(url){
            return `${this.$store.state.HOST}/${url}`
        }
    },

    
}