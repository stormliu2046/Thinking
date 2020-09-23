package com.example.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author robert
 */
@Slf4j
public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"errcode\":0,\"data\":{\"result\":{\"profile\":{\"approvalNo\":\"202009170847000313875\",\"exApprovalNo\":\"fundraising-202009170847000318743\",\"procDefId\":\"8cfa145b-f403-11ea-92ec-52540043dbcf\",\"procDefKey\":\"fundraising_application_process_v001\",\"procDefTitle\":\"筹款申请流程\",\"procInstId\":\"f36db84e-f8e3-11ea-92ec-52540043dbcf\",\"formDefId\":\"\",\"formInstId\":\"\",\"exFormInstId\":\"23\",\"exFormDefKey\":\"project_add\",\"approvalStatus\":\"processing\",\"timestamp\":1600346852007,\"corpId\":\"1\",\"corpBizCategory\":\"fundraising\",\"initiator\":\"100\",\"initiatorDept\":\"1\",\"initiatorName\":\"Admin\",\"endTimestamp\":0,\"approver\":\"100\",\"approverName\":\"Admin\",\"assignee\":\"\",\"assigneeName\":\"\",\"mqHeaderJson\":\"{\\\"amqp_receivedDeliveryMode\\\":\\\"PERSISTENT\\\",\\\"amqp_receivedExchange\\\":\\\"fundraisingApplicationApprovalProcessDest\\\",\\\"amqp_deliveryTag\\\":14,\\\"joosure_category\\\":\\\"fundraising\\\",\\\"amqp_consumerQueue\\\":\\\"fundraisingApplicationApprovalProcessDest.fundraisingApplicationGroup\\\",\\\"amqp_redelivered\\\":false,\\\"amqp_receivedRoutingKey\\\":\\\"fundraising.application.approval.process.request\\\",\\\"spring_listener_return_correlation\\\":\\\"9bb3648d-b14c-4d20-bc90-c8bd909a18de\\\",\\\"joosure_bizType\\\":\\\"applicationApprovalProcess\\\",\\\"spring_returned_message_correlation\\\":\\\"c2fc89b0-d859-6dc7-d217-b021418f54cc\\\",\\\"amqp_timestamp\\\":\\\"2020-09-17T12:47:31.000+0000\\\",\\\"joosure_authCode\\\":\\\"Basic MTAw\\\",\\\"amqp_messageId\\\":\\\"c2fc89b0-d859-6dc7-d217-b021418f54cc\\\",\\\"id\\\":\\\"7dcc834d-fba9-01c7-3c75-f617500ac726\\\",\\\"amqp_consumerTag\\\":\\\"amq.ctag-p6N5k0fM4uGdzCS4uf2N8A\\\",\\\"contentType\\\":{\\\"type\\\":\\\"application\\\",\\\"subtype\\\":\\\"json\\\",\\\"parameters\\\":{},\\\"wildcardType\\\":false,\\\"wildcardSubtype\\\":false,\\\"concrete\\\":true,\\\"charset\\\":null},\\\"timestamp\\\":1600346851276}\"},\"nodeModels\":[{\"approvalNo\":\"202009170847000313875\",\"nodeDefId\":\"sid-9AEAF4F3-8BB0-45F5-9314-781B2A50BABB\",\"nodeRuId\":\"\",\"assignee\":\"100\",\"approvalType\":\"model\",\"approvalStatus\":\"processing\",\"multiInstApprovalType\":\"parallelAnd\",\"haveComment\":false,\"timestamp\":1600346852023,\"approvalAgentType\":\"\",\"nodeDefUser\":\"100\",\"approvalSubType\":\"taskApproval\",\"approvalTitle\":\"捐赠审批测试\",\"corpId\":\"1\",\"corpBizCategory\":\"fundraising\",\"nodeDefUserName\":\"Admin\",\"assigneeName\":\"Admin\"}],\"taskDetails\":[{\"detail\":{\"approvalNo\":\"202009170847000313875\",\"nodeDefId\":\"8cfa145b-f403-11ea-92ec-52540043dbcf\",\"nodeRuId\":\"f36db84e-f8e3-11ea-92ec-52540043dbcf\",\"assignee\":\"100\",\"approvalType\":\"initiatorClaim\",\"approvalStatus\":\"processed\",\"multiInstApprovalType\":\"\",\"haveComment\":true,\"timestamp\":1600346852023,\"approvalAgentType\":\"\",\"nodeDefUser\":\"100\",\"approvalSubType\":\"initiator\",\"approvalTitle\":\"筹款申请流程\",\"corpId\":\"1\",\"corpBizCategory\":\"fundraising\",\"nodeDefUserName\":\"Admin\",\"assigneeName\":\"Admin\"},\"comments\":[{\"approvalNo\":\"202009170847000313875\",\"nodeRuId\":\"f36db84e-f8e3-11ea-92ec-52540043dbcf\",\"commentId\":\"13f5a996-f8e4-11ea-92ec-52540043dbcf\",\"picResourceId\":\"\",\"attResourceId\":\"\",\"timestamp\":1600346905932,\"message\":\"啊啊啊\",\"createdByUser\":\"100\",\"createdByUserName\":\"Admin\",\"type\":\"additional\"}]}],\"myApprovalTasks\":[{\"approvalNo\":\"202009170847000313875\",\"nodeDefId\":\"8cfa145b-f403-11ea-92ec-52540043dbcf\",\"nodeRuId\":\"f36db84e-f8e3-11ea-92ec-52540043dbcf\",\"assignee\":\"100\",\"approvalType\":\"initiatorClaim\",\"approvalStatus\":\"processed\",\"multiInstApprovalType\":\"\",\"haveComment\":true,\"timestamp\":1600346852023,\"approvalAgentType\":\"\",\"nodeDefUser\":\"100\",\"approvalSubType\":\"initiator\",\"approvalTitle\":\"筹款申请流程\",\"corpId\":\"1\",\"corpBizCategory\":\"fundraising\",\"nodeDefUserName\":\"Admin\",\"assigneeName\":\"Admin\"},{\"approvalNo\":\"202009170847000313875\",\"nodeDefId\":\"sid-9AEAF4F3-8BB0-45F5-9314-781B2A50BABB\",\"nodeRuId\":\"f36e2da2-f8e3-11ea-92ec-52540043dbcf\",\"assignee\":\"100\",\"approvalType\":\"taskApproval\",\"approvalStatus\":\"processing\",\"multiInstApprovalType\":\"parallelAnd\",\"haveComment\":false,\"timestamp\":1600346852023,\"approvalAgentType\":\"\",\"nodeDefUser\":\"100\",\"approvalSubType\":\"\",\"approvalTitle\":\"捐赠审批测试\",\"corpId\":\"1\",\"corpBizCategory\":\"fundraising\",\"nodeDefUserName\":\"Admin\",\"assigneeName\":\"Admin\"}]}},\"errmsg\":\"成功\"}";
        ObjectMapper mapper = new ObjectMapper();

        // fastJson可以直接get节点得到jsonStr
//        JSONObject jsonObject = JSON.parseObject(json);
//        String jsonStr =  jsonObject.getString("data");
//        System.out.println(jsonStr);

        // 此处要注意的是，jackson如果得到的节点不是最底层的节点，使用.asText()之类的方法会报错
        JsonNode jsonNode = mapper.readTree(json);
        JsonNode jsonStr =  jsonNode.get("data");
        log.info(mapper.writeValueAsString(jsonStr));
    }
}
