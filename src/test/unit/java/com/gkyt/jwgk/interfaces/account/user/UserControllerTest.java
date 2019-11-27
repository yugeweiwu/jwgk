package com.gkyt.jwgk.interfaces.account.user;

import com.alibaba.fastjson.JSON;
import com.gkyt.jwgk.application.account.user.UserApplicationService;
import com.gkyt.jwgk.application.account.user.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserApplicationService userApplicationService;

    @Test
    public void getUser() throws Exception{
        //Given 准备数据 创建我们Mock的函数的返回值，或者我们将要测试方法的输入参数
        BDDMockito.given(userApplicationService.get("1")).willReturn(getUserModel());

        //When  模拟调用我们要测试的controller方法
        ResultActions result = this.mockMvc
                .perform(get("/user/{id}","1").accept(MediaType.APPLICATION_JSON));

        //Then 主要的点在这里得到断言 编写接口文档
        //andExpect添加执行完成后的断言
        // //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
        result.andExpect(status().isOk())
                .andExpect(content().json(JSON.toJSONString(getUserModel())))
                .andDo(document("account/user/get-by-id/",
                        pathParameters(getIdParameterDescriptor()),
                        responseFields(getClientViewModelFieldDescriptors())));
    }

    private UserModel getUserModel(){
        UserModel userModel = new UserModel();
        userModel.setId("1");
        userModel.setPhone("1234");
        userModel.setUserName("tongsongmin");
        return userModel;
    }

    private ParameterDescriptor getIdParameterDescriptor() {
        return parameterWithName("id").attributes(key("required").value(true)).description("标识");
    }

    private FieldDescriptor[] getClientViewModelFieldDescriptors() {
        return new FieldDescriptor[]{
                fieldWithPath("id").description("标识"),
                fieldWithPath("userName").description("姓名"),
                fieldWithPath("phone").description("号码")};
    }
}
