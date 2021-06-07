export const mixin = {
    methods:{
        // notify information
        notify(title, type){
            this.$notify({
                title: title,
                type: type
            })
        }
    }
}