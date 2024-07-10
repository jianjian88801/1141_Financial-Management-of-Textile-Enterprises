import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import baoxiao from '@/views/modules/baoxiao/list'
    import caiwurenyuan from '@/views/modules/caiwurenyuan/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import liuyan from '@/views/modules/liuyan/list'
    import shoufeixinxi from '@/views/modules/shoufeixinxi/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yuangong from '@/views/modules/yuangong/list'
    import zhichuxinxi from '@/views/modules/zhichuxinxi/list'
    import dictionaryBaoxiao from '@/views/modules/dictionaryBaoxiao/list'
    import dictionaryBaoxiaoYesno from '@/views/modules/dictionaryBaoxiaoYesno/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShoufeixinxi from '@/views/modules/dictionaryShoufeixinxi/list'
    import dictionaryZhichuxinxi from '@/views/modules/dictionaryZhichuxinxi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBaoxiao',
        name: '报销类型',
        component: dictionaryBaoxiao
    }
    ,{
        path: '/dictionaryBaoxiaoYesno',
        name: '是否同意',
        component: dictionaryBaoxiaoYesno
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShoufeixinxi',
        name: '收费类型',
        component: dictionaryShoufeixinxi
    }
    ,{
        path: '/dictionaryZhichuxinxi',
        name: '支出类型',
        component: dictionaryZhichuxinxi
    }


    ,{
        path: '/baoxiao',
        name: '报销信息',
        component: baoxiao
      }
    ,{
        path: '/caiwurenyuan',
        name: '财务人员',
        component: caiwurenyuan
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/liuyan',
        name: '留言',
        component: liuyan
      }
    ,{
        path: '/shoufeixinxi',
        name: '收费信息',
        component: shoufeixinxi
      }
    ,{
        path: '/xinzi',
        name: '薪资',
        component: xinzi
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }
    ,{
        path: '/zhichuxinxi',
        name: '支出信息',
        component: zhichuxinxi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
