const base = {
    get() {
        return {
            url : "http://localhost:8080/qiyecaiwuguanli/",
            name: "qiyecaiwuguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/qiyecaiwuguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "纺织品企业财务管理系统"
        } 
    }
}
export default base
