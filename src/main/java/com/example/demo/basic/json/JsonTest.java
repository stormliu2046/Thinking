package com.example.demo.basic.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

/**
 * Jackson null处理
 * @author robert
 */
public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"baseInfo\":{\"projectName\":\"项目名称\",\"productName\":\"商品名称\",\"principal\":\"项目负责人\",\"projectType\":\"2\",\"relatedProjectId\":13,\"relatedProjectName\":\"我随手一打就是十个\",\"pageVersion\":\"detailed\",\"pageThemeColor\":\"#C36ED8\"},\"fundraisingContentInfo\":{\"projectNo\":\"432423947917429347\",\"projectBrief\":\"4324\",\"pageCoverPic\":\"/prm/cs/open/cs/oss/resource/293244/v2\",\"projectLocation\": null,\"projectStartTime\":1603940696797,\"projectEndTime\":1606532696797,\"donateWay\":3,\"donateAmountItems\":[{\"amount\":100,\"description\":\"11\"},{\"amount\":200,\"description\":\"22\"},{\"amount\":300,\"description\":\"33\"},{\"amount\":null,\"description\":\"\"},{\"amount\":null,\"description\":\"\"}],\"targetFundraisingAmount\":3432400,\"projectDesc\":\"<p>4234</p>\",\"projectBudget\":2343400,\"projectExecutePlan\":\"4324\",\"organizationPrincipal\":\"434\",\"projectExecuteEffect\":\"\",\"donationCapacityStatement\":\"\",\"donateFeedback\":\"\",\"isUseYjjBrief\":\"0\",\"aboutUs\":\"<p>关于我们</p>\"},\"donateOrderExtraInfo\":[{\"sort\":0,\"key\":\"name\",\"label\":\"捐赠人姓名\",\"customerCode\":\"姓名\",\"isRequired\":1,\"inputType\":\"singleLine\"},{\"sort\":1,\"key\":\"mobile\",\"label\":\"捐赠人手机号\",\"customerCode\":\"手机号\",\"isRequired\":1,\"inputType\":\"singleLine\"},{\"label\":\"性别\",\"customerCode\":\"性别\",\"inputType\":\"singleSelect\",\"isRequired\":0,\"selectSetting\":[{\"code\":0,\"content\":\"男\"},{\"code\":1,\"content\":\"女\"}],\"sort\":2,\"key\":\"sex\"},{\"label\":\"工作状态\",\"customerCode\":\"工作状态\",\"inputType\":\"singleSelect\",\"isRequired\":0,\"selectSetting\":[{\"code\":0,\"content\":\"全职\"},{\"code\":1,\"content\":\"兼职\"},{\"code\":2,\"content\":\"实习\"},{\"code\":3,\"content\":\"离职\"}],\"prompt\":\"2\",\"sort\":3,\"key\":\"workingStatus\"}],\"fundraisingPageShare\":{\"shareIconPic\":\"/prm/cs/open/cs/oss/resource/293244/v2\",\"shareTitle\":\"标题\",\"shareDesc\":\"描述\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode jsonNode1 = jsonNode.get("fundraisingContentInfo");
        JsonNode jsonNode2 = jsonNode1.get("projectLocation");
        System.out.println(jsonNode2);
        System.out.println(jsonNode2.isNull());
        System.out.println(jsonNode2.asText());
        System.out.println(StringUtils.isBlank(jsonNode2.asText()));
    }
}
