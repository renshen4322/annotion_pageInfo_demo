/*
package com.dn.test;


import com.dn.signature.comm.DeclareDetails;
import com.dn.signature.comm.FileBean;
import com.dn.signature.enums.HeaderConstant;
import com.dn.signature.factory.Factory;
import com.dn.signature.factory.account.CreateOrganizationsByThirdPartyUserId;
import com.dn.signature.factory.account.CreatePersonByThirdPartyUserId;
import com.dn.signature.factory.base.Account;
import com.dn.signature.factory.base.FileTemplate;
import com.dn.signature.factory.filetemplate.GetFileUploadUrl;
import com.dn.signature.factory.filetemplate.UploadFile;
import com.dn.signature.factory.response.CreateOrganizationsByThirdPartyUserIdResponse;
import com.dn.signature.factory.response.CreatePersonByThirdPartyUserIdResponse;
import com.dn.signature.factory.response.GetFileUploadUrlResponse;
import com.dn.signature.factory.response.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*/
/**
 * @description  轩辕API企业和个人签署代码示例
 * @author  澄泓
 * @date  2020/10/30 11:32
 * @version JDK1.7
 *//*

public class b2cDemo {
    //此示例为企业和个人场景的签署示例代码，签署方式为一步发起签署，如果需要分步签署，签署部分代码示例可参考b2bDemo
    static{
        DeclareDetails.showImportantMessage();//demo声明明细
//        正式环境域名：https://openapi.esign.cn
//        模拟环境（沙箱环境）域名：https://smlopenapi.esign.cn
        String host="https://smlopenapi.esign.cn"; //网关
        String project_id="7438881477";//应用id
        String project_scert="b417a06f8c790ced2918f173d7ade528";//密钥
        Factory.init(host,project_id,project_scert);//初始化，传入请求网关，应用id以及密钥,全局一次
        Factory.setDebug(true);//开启日志，测试阶段建议开启，方便记录数据，日志保存在根目录的log.txt文件中
    }
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(b2cDemo.class);

        try{
            String filePath="C:\\DELL\\01-Reactor.pdf";//文件地址

            //------------------------企业账号信息用于创建机构账号接口传入----------------
            String thirdPartyUserIdOrg="12123123123152121234432";//thirdPartyUserId参数，用户唯一标识，自定义保持唯一即可
            String nameOrg="上海佳和健康管理有限公司";//name参数，机构名称
            String idTypeOrg="CRED_ORG_USCC";//idType参数，证件类型
            String idNumberOrg="91310000MA7AGX5E2J";//idNumber参数,机构证件号

            //创建个人账号
            //cn.tign.hz.factory.base.Account;
            //Account类是账号相关的功能类，所有账号相关方法由Account发起
           logger.info("------------------ 创建个人账号1 start -----------------");
            //-----------------------个人账号信息用于创建个人账号接口传入-----------------------------
            String thirdPartyUserIdPsn="1232132112002";//thirdPartyUserId参数，用户唯一标识，自定义保持唯一即可
            String namePsn="胡东辉";//name参数，姓名
            String idTypePsn="CRED_PSN_CH_IDCARD";//idType参数，证件类型
            String idNumberPsn="431103198812133926";//idNumber参数，证件号
            String mobilePsn="15921439750";//mobile参数，手机号
            CreatePersonByThirdPartyUserId createPsn = Account.createPersonByThirdPartyUserId(
                    thirdPartyUserIdPsn,
                    namePsn,
                    idTypePsn,
                    idNumberPsn);
            createPsn.setMobile(mobilePsn);
            CreatePersonByThirdPartyUserIdResponse createPsnResp = createPsn.execute();//execute方法发起请求
            String accountId = createPsnResp.getData().getAccountId();//生成的个人账号保存好，后续接口调用需要使用
            logger.info("个人账号accountId--"+accountId);
            logger.info("------------------ 创建个人账号1 end -----------------");


            logger.info("------------------ 创建个人账号2 start -----------------");
            String thirdPartyUserIdPsn2="35236236009";//thirdPartyUserId参数，用户唯一标识，自定义保持唯一即可
            String namePsn2="陈平";//name参数，姓名
            String idTypePsn2="CRED_PSN_CH_IDCARD";//idType参数，证件类型
            String idNumberPsn2="431103198212193920";//idNumber参数，证件号
            String mobilePsn2="14776350509";//mobile参数，手机号

            CreatePersonByThirdPartyUserId createPsn2 = Account.createPersonByThirdPartyUserId(
                    thirdPartyUserIdPsn2,
                    namePsn2,
                    idTypePsn2,
                    idNumberPsn2);
            createPsn2.setMobile(mobilePsn2);
            CreatePersonByThirdPartyUserIdResponse createPsnResp2 = createPsn2.execute();//execute方法发起请求
            String accountId2 = createPsnResp2.getData().getAccountId();//生成的个人账号保存好，后续接口调用需要使用
            logger.info("个人账号accountId--"+accountId2);
            logger.info("------------------ 创建个人账号2 end -----------------");

            logger.info("------------------ 创建企业账号 start -----------------");
            CreateOrganizationsByThirdPartyUserId createOrg = Account.createOrganizationsByThirdPartyUserId(
                    thirdPartyUserIdOrg,
                    accountId2,
                    nameOrg,
                    idTypeOrg,
                    idNumberOrg);

            CreateOrganizationsByThirdPartyUserIdResponse createOrgResp = createOrg.execute();//execute方法发起请求
            String orgId = createOrgResp.getData().getOrgId();//生成的企业账号保存好，后续接口调用需要使用
            logger.info ("------------------ 创建企业账号 end -----------------");

            logger.info ("------------------ 创建个人模板印章 start -----------------");
            //cn.tign.hz.factory.base.Seals;

            logger.info ("------------------ 通过上传方式创建文件 start -----------------");
            //cn.tign.hz.factory.base.FileTemplate;
            //FileTemplate是文件模板功能类，所有文件模板相关的接口由FileTemplate发起
            FileBean fileBean = new FileBean(filePath);//用于本地获取文件大小，名称等信息
            GetFileUploadUrl fileUploadUrl = FileTemplate.getFileUploadUrl(fileBean.getFileContentMD5(),
                    HeaderConstant.CONTENTTYPE_PDF.VALUE(),
                    false,
                    fileBean.getFileName(),
                    fileBean.getFileSize());
            GetFileUploadUrlResponse fileUploadUrlResp = fileUploadUrl.execute();
            String fileId = fileUploadUrlResp.getData().getFileId();//文件id保存好，后续使用
            String uploadUrl = fileUploadUrlResp.getData().getUploadUrl();//上传url保存好，后续使用
            logger.info ("------------------ 通过上传方式创建文件 end -----------------");

            logger.info ("------------------ 文件流上传方法 start -----------------");
            UploadFile uploadFile = FileTemplate.uploadFile(uploadUrl, filePath, HeaderConstant.CONTENTTYPE_PDF.VALUE());
            UploadFileResponse uploadFileResp = uploadFile.excute();
            logger.info ("------------------ 文件流上传方法 end -----------------");

            logger.info ("------------------ 一步发起签署 start -----------------");
            //这里以一步发起签署为例，如果想查看分步发起签署代码示例，可以看b2bDemo
            //cn.tign.hz.factory.base.SignFile;
            //SignFile是文件模板功能类，所有文件模板相关的接口由SignFile发起
            Docs docs = new Docs();//入参是array格式时，先构造对象参数的array
            docs.add(new Doc().setFileId(fileId));//向array传入对象
            FlowInfo flowInfo = new FlowInfo().setBusinessScene("b2c合同签署测试")//flowInfo参数
                    .setAutoArchive(true)//启用自动归档
                    .setAutoInitiate(true).setInitiatorAccountId(accountId).setInitiatorAuthorizedAccountId(accountId);//启用自动开启流程

            Signfields psnSignfields = new Signfields();
            psnSignfields.add(new Signfield()
                    .setFileId(fileId)
                    .setPosBean(new PosBean()
                            .setPosPage("1")
                            .setPosX(200)
                            .setPosY(20)).setSignDateBeanType(1));//构造个人signfields参数对象,用于后续入参使用,支持链式入参

            Signfields orgSignfields = new Signfields();
            orgSignfields.add(new Signfield()
                    .setFileId(fileId)
                    .setActorIndentityType("2")//机构签署必传
                    .setPosBean(new PosBean()
                            .setPosPage("1")
                            .setPosX(500)
                            .setPosY(20)).setSignDateBeanType(1));//构造企业signfields参数对象,用于后续入参使用,支持链式入参

            Signers signers = new Signers();
            signers.add(new Signer()
                    .setSignerAccount(
                            new SignerAccount()
                                    .setSignerAccountId(accountId)
                    ).setSignFields(psnSignfields).setSignOrder(1));//传入个人signer信息
            signers.add(new Signer()
                    .setSignerAccount(
                            new SignerAccount()
                                    .setSignerAccountId(accountId2)//签署经办人
                                    .setAuthorizedAccountId(orgId)//企业签署需要传入该参数
                    ).setSignFields(orgSignfields).setSignOrder(2));//传入企业signer信息
            CreateFlowOneStep flowOneStep = SignFile.createFlowOneStep(docs, flowInfo, signers);
            CreateFlowOneStepResponse flowOneStepResp = flowOneStep.execute();
            String flowId = flowOneStepResp.getData().getFlowId();//流程id保存好
            logger.info ("------------------ 一步发起签署 end -----------------");

            //开启流程后会向个人实名手机号发送签署信息，会向企业签署经办人发送信息，也可以调用获取签署地址接口获取签署链接
            logger.info ("------------------ 获取签署地址 start -----------------");
            GetFileSignUrl fileSignUrl = SignFile.getFileSignUrl(flowId, accountId);
            fileSignUrl.setOrganizeId(orgId);
            GetFileSignUrlResponse fileSignUrlResp = fileSignUrl.execute();
            String shortUrl = fileSignUrlResp.getData().getShortUrl();//响应的签署链接，复制到浏览器访问即可打开签署页面
            logger.info("签署短连接,复制到浏览器打开\n"+shortUrl);
            logger.info ("------------------ 获取签署地址 end -----------------");
            logger.info("------flowId-------:"+flowId);
            logger.info("个人账号accountId--"+accountId);

        }catch (DefineException e){
            e.printStackTrace();
            logger.info(e.getMessage()+e.getCause());
        }
        logger.info("正常运行结束");
    }
}
*/
