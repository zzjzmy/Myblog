<template>
    <div>
        <Header></Header>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="搜索" prop="keyword">
                    <el-input v-model="ruleForm.keyword"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="page(ruleForm.keyword)">确认</el-button>
                </el-form-item>
        </el-form>
        <el-timeline>
            <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs" :key="blog.id">
            <el-card>
                <router-link :to="{name:'BlogDetail',params:{blogId:blog.id}}">
                    <h4>{{blog.title}}</h4>
                </router-link>
                    <p>{{blog.description}}</p>
            </el-card>
            </el-timeline-item>
        </el-timeline> 
        <el-pagination class="mpage" background layout="prev, pager, next"
            :current-page="currentPage" :page-size="pageSize" :total="total" @current-change="page">
        </el-pagination>       
    </div>    
</template>
<script>
import Header from "../components/Header";
export default {
        name: "BlogLike",
        components: {Header},
        data() {
            return {
                blogs: [], // 定义用于保存查询结果的数组
                ruleForm: {
                    keyword: ''
                },
                rules: {
                    title: [
                        {required: true, message: '请输入', trigger: 'blur'},
                    ],
                },
                currentPage: 1,
                pageSize: 10,
                total: 0  
            };
        },
        created() {
            this.page(1);
        },
        methods:{
             //请求指定页的方法
             page(keyword) {
                const _this = this;
                _this.$axios.get("/blogs/like?keyword=" + keyword,{
                    headers: {
                        "authorization": localStorage.getItem("token")
                    }
                }).then(res => {
                    console.log(res)
                    //从获取到的数据中进行赋值
                    _this.blogs = res.data.data.records
                    _this.currentPage = res.data.data.current
                    _this.total = res.data.data.total
                    _this.pageSize = res.data.data.size
                })
             },
        }
}
</script>

