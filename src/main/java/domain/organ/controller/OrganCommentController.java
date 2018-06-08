package domain.organ.controller;

import domain.base.controller.AbstractActionController;
import domain.base.entity.JsonResponseVO;
import domain.organ.entity.OrganEntity;
import domain.organ.service.OrganCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.organ.OrganWebForward.TO_ORGAN_COMMENT_PAGE;
import static domain.organ.OrganWebURLMapping.*;

/**
 * 机关进校园提交
 */

@Controller
public class OrganCommentController extends AbstractActionController{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganCommentController.class);

    final private OrganCommentService organCommentService;

    @Autowired
    public OrganCommentController(OrganCommentService organCommentService){
        this.organCommentService = organCommentService;
    }

    /**
     * 去机关进校园页面
     * @return ModelAndView
     */
    @RequestMapping(value = ORGAN_COMMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(TO_ORGAN_COMMENT_PAGE);
    }

    /**
     * 机关进校园新增
     * @param organEntity 新增实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ORGAN_COMMENT_ADD)
    @ResponseBody
    public JsonResponseVO organComment(@RequestBody OrganEntity organEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        try {
            organEntity.setCreateUserId(getListenerId());
            final Boolean flag = organCommentService.organComment(organEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("机关进校园提交，title:{}",organEntity.getCheckTitle());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }
        return jsonResponseVO;
    }

    /**
     * 机关进校园修改
     * @param organEntity 修改实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ORGAN_COMMENT_EDIT)
    @ResponseBody
    public JsonResponseVO organEdit(@RequestBody OrganEntity organEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            organEntity.setUpdateUserId(getListenerId());
            final Boolean flag = organCommentService.organEdit(organEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("机关进校园修改，title:{}",organEntity.getCheckTitle());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }
        return jsonResponseVO;
    }
}
