package com.gkyt.jwgk.interfaces.account;

import com.gkyt.jwgk.application.account.user.UserApplicationService;
import com.gkyt.jwgk.application.account.user.UserModel;
import com.gkzx.shared.util.JsonUtils;
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
public class UserControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserApplicationService userApplicationService;

    @Test
    public void getUser() throws Exception{
        //Given
        BDDMockito.given(userApplicationService.get("1")).willReturn(getUserModel());

        //When
        ResultActions result = this.mockMvc.perform(get("/user/{id}","1")
                .accept(MediaType.APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().json(JsonUtils.toJsonString(getUserModel())))
                .andDo(document("account/user/get-by-id/",
                        pathParameters(getIdParameterDescriptor()),
                        responseFields(getClientViewModelFieldDescriptors())));
    }

    private UserModel getUserModel(){
        UserModel userModel = new UserModel();
        userModel.setPhone("1234");
        userModel.setUserName("tongsongmin");
        return userModel;
    }

    private ParameterDescriptor getIdParameterDescriptor() {
        return parameterWithName("id").attributes(key("required").value(true)).description("标识");
    }

    private FieldDescriptor[] getClientViewModelFieldDescriptors() {
        return new FieldDescriptor[]{
                fieldWithPath("userName").description("姓名"),
                fieldWithPath("phone").description("号码"),
                fieldWithPath("status").description("状态"),
                fieldWithPath("createdTime").description("创建时间"),
                fieldWithPath("lastUpdatedTime").description("最后修改时间")};
    }
}
