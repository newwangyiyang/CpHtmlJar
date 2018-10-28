package cn.yiyang.system.config.wx.handler;

import java.util.Map;

import cn.yiyang.system.config.wx.builder.TextBuilder;
import cn.yiyang.system.config.wx.utils.JsonUtils;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                  WxSessionManager sessionManager) {

    if (!wxMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)) {
      //TODO 可以选择将消息保存到本地
    }

    //TODO 组装回复消息
    String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);

    return new TextBuilder().build(content, wxMessage, cpService);

  }

}
