<template>
  <div id="userRegisterPage">
    <h2 style="margin-bottom: 16px">用户注册</h2>
    <a-form
      :model="form"
      :style="{ width: '480px', margin: '0 auto' }"
      label-align="left"
      auto-label-width
      @submit="handleSubmit"
    >
      <a-form-item
        field="userAccount"
        tooltip="Please enter username"
        label="账户"
      >
        <a-input
          v-model="form.userAccount"
          placeholder="please enter your username..."
        />
      </a-form-item>
      <a-form-item field="userPassword" tooltip="密码不小于8位" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="please enter your password..."
        />
      </a-form-item>
      <a-form-item
        field="checkPassword"
        tooltip="确认密码不小于8位"
        label="确认密码"
      >
        <a-input-password
          v-model="form.checkPassword"
          placeholder="please enter your checkpassword..."
        />
      </a-form-item>
      <a-form-item>
        <div
          style="
            display: flex;
            width: 100%;
            align-items: center;
            justify-content: space-between;
          "
        >
          <a-button html-type="primary" style="width: 120px">注册</a-button>
          <a-link href="/user/login">登录</a-link>
        </div>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import API from "@/api";
import { userRegisterUsingPost } from "@/api/userController";
import { useLoginUserStore } from "@/store/userStore";
import message from "@arco-design/web-vue/es/message";
import router from "@/router";

const loginUserStore = useLoginUserStore();

const form = reactive({
  userAccount: "",
  userPassword: "",
  checkPassword: "",
} as API.UserRegisterRequest);

/**
 * 提交
 */
const handleSubmit = async () => {
  console.log(form);
  const res = await userRegisterUsingPost(form);
  if (res.data.code === 0) {
    await loginUserStore.fetchLoginUser();
    message.success("注册成功");
    router.push({
      path: "/user/login",
      replace: true,
    });
  } else {
    message.error("注册失败，" + res.data.message);
  }
};
</script>

<style scoped></style>
