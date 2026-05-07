// 定制请求的实例
import axios from 'axios';
import { ElMessage } from 'element-plus';
import router from '@/router';

const baseURL = 'http://localhost:8080';
const instance = axios.create({ baseURL });

// ==================== 响应拦截器（统一使用这个） ====================
instance.interceptors.response.use(
    response => {
        console.log('✅ 后端返回数据:', response.data);

        const res = response.data;

        if (res == null) {
            ElMessage.error('服务器返回数据为空');
            return Promise.reject(new Error('响应数据为空'));
        }

        // 成功
        if (res.code === 0) {
            // ElMessage.success(res.msg || '操作成功');   // 成功时可取消注释
            return res;
        }
        // 失败
        else {
            ElMessage.error(res.msg || '操作失败');
            return Promise.reject(res);
        }
    },
    error => {
        console.error('❌ 请求错误:', error);

        if (error.response?.status === 401) {
            ElMessage.error('请先登录');
            router.push('/login');
        } else {
            ElMessage.error('网络请求失败');
        }
        return Promise.reject(error);
    }
);

export default instance;