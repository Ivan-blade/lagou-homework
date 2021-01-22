<template>
  <div>
			<el-dialog
				style="width:800px;margin:0px auto;"
				title=""
				:visible.sync="dialogFormVisible">
				<!-- 登录表单-->
					<el-form>
						<el-form-item>
							<h1 style="font-size:30px;color:#00B38A">拉勾</h1>
						</el-form-item>
						<el-form-item>
							<el-input v-model="oldpassword" placeholder="请输入当前密码"></el-input>
						</el-form-item>
						<el-form-item>
							<el-input v-model="newpassword" placeholder="请输入新密码"></el-input>
						</el-form-item>
						<el-form-item>
							<el-input v-model="cpassword" placeholder="请确认密码"></el-input>
						</el-form-item>
					</el-form>
					<el-button
						style="width:100%;margin:0px auto;background-color: #00B38A;font-size:20px"
						type="primary"
						@click="updatePassword">确 定</el-button>
					<p></p>
			</el-dialog>
      <el-header>
          <div @click="goToLesson">课程列表</div>
      </el-header>
      <el-container style="height: 1280px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '1']">
            <el-submenu index="1">
                <template slot="title"><i class="el-icon-message"></i>账号设置</template>
                <el-submenu index="1-1">
                    <template slot="title">通用设置</template>
                    <el-menu-item index="1-1-1">基本设置</el-menu-item>
                </el-submenu>
                <el-submenu index="1-2">
                    <template slot="title">隐私设置</template>
                    <el-menu-item index="1-2-1">账号绑定</el-menu-item>
                    <el-menu-item index="1-2-2" @click="changeStatus">修改密码</el-menu-item>
                </el-submenu>
            </el-submenu>
            </el-menu>
        </el-aside>
        
        <el-container>
            <el-header style="text-align: right; font-size: 12px">
            </el-header>
            <el-main>
                <div>
                    <el-upload
                        class="upload-demo"
                        action="/api/user/uploadFile"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :before-remove="beforeRemove"
                        :on-success="uploadSuccess"
                        multiple
                        :file-list="fileList">
                        <el-button size="small" type="primary">点击上传</el-button>
                    </el-upload>
                    <el-form>
                        <el-form-item>
                            <el-input v-model="name" placeholder="请输入修改后名称"></el-input>
                        </el-form-item>
                    </el-form>
                    <el-button
                    style="width:100%;margin:0px auto;background-color: #00B38A;font-size:20px"
                    type="primary"
                    @click="updateUserInfo">确 定</el-button>
                    <p></p>
                </div>
            </el-main>
        </el-container>
      </el-container>
  </div>
</template>

<script>
export default {
    name: "Setting",
    data() {
      return {
				userDTO: null,
				name: '',
				fileList: [],
				dialogFormVisible: false,
				oldpassword: '',
				newpassword: '',
				cpassword: ''
      };
    },
    methods: {
			changeStatus() {
				this.dialogFormVisible = !this.dialogFormVisible
			},
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      goToLesson() {
        this.$router.push({path: "/"})
      },
      uploadSuccess(res) {
        this.userDTO.content.portrait = '172.16.161.136/'+res.message;
      },
      updateUserInfo() {
				this.axios({
						method:'post',
						url:'/api/user/updateUserInfo',
						params:{
							name: this.name,
							id: this.userDTO.content.id,
							portrait: this.userDTO.content.portrait
						}
					}).then( (result)=>{
						this.$message.success(result.data.message);
        })
        .catch( (error)=>{
           this.$message.error('修改失败');
        });
			},
			updatePassword() {
				if(this.newpassword != this.cpassword) {
					this.$message.error('两次密码不一致!')
				} else {
					this.axios({
						method:'post',
						url:'/api/user/updatePassword',
						params:{
							id: this.userDTO.content.id,
							oldpassword: this.oldpassword,
							newpassword: this.newpassword
						}
					}).then((res) => {
						console.log(res)
					}).catch((err) => {
						console.log(err)
					})
				}
			}
		},
		created(){
				// 当刷新页面，组件创建成功之后，立刻检测本地储存中是否存在用户对象
				this.userDTO = JSON.parse( localStorage.getItem("user") );
				if(this.userDTO == null){
						this.$router.push({path: '/'})
				}
		}
}
</script>

<style>
.el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>