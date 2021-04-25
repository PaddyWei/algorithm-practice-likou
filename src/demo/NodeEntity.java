package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : NodeEntity
 * @Description : 节点实体类
 * @Author : DukeWei
 * @Date : 2021/4/25 16:44
 * @Version : 1.0
 **/
public class NodeEntity {

    private Long id;

    private Long topParentId;

    private Long parentId;

    private List<NodeEntity> nodeEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopParentId() {
        return topParentId;
    }

    public void setTopParentId(Long topParentId) {
        this.topParentId = topParentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<NodeEntity> getNodeEntityList() {
        if (nodeEntityList == null) {
            return new ArrayList<>();
        }
        return nodeEntityList;
    }

    public void setNodeEntityList(List<NodeEntity> nodeEntityList) {
        this.nodeEntityList = nodeEntityList;
    }

    public NodeEntity(Long id, Long topParentId, Long parentId) {
        this.id = id;
        this.topParentId = topParentId;
        this.parentId = parentId;
    }

    public NodeEntity() {
    }

    @Override
    public String toString() {
        return "NodeEntity{" +
                "id=" + id +
                ", topParentId=" + topParentId +
                ", parentId=" + parentId +
                ", nodeEntityList=" + nodeEntityList +
                '}';
    }
}
