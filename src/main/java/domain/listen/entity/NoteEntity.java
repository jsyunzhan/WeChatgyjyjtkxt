package domain.listen.entity;

import domain.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
/**
 * 听课笔记实体
 */
public class NoteEntity extends AbstractEntity {

    //听课人员id
    private Long listenerId;

    //听课学校id
    private Long schoolId;

    //听课学校名称
    private String schoolName;

    //班级名称
    private String className;

    //上课教师名称
    private String teacherName;

    //学科id
    private Long disciplineId;

    //学科名称
    private String disciplineName;

    //课题
    private String subject;


    //是否推荐(0:不推荐,1：推荐)
    private Long shareFlag;

    //评价
    private String comments;

    //图片路径
    private String picturePath;

    //图片数组
    private byte[] pictureByts;

    //听课评分id
    private Long scoreId;

    //听课评分名字
    private String scoreName;

    //听课地点
    private String listenPath;

    //听课开始时间
    private String beginDate;

    //听课结束时间
    private String endDate;


    @Override
    public String toString() {
        return "NoteEntity{" +
                "listenerId=" + listenerId +
                ", schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", className='" + className + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", disciplineId=" + disciplineId +
                ", disciplineName='" + disciplineName + '\'' +
                ", subject='" + subject + '\'' +
                ", shareFlag=" + shareFlag +
                ", comments='" + comments + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureByts=" + Arrays.toString(pictureByts) +
                ", scoreId=" + scoreId +
                ", scoreName='" + scoreName + '\'' +
                ", listenPath='" + listenPath + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
