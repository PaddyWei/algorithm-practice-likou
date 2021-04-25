package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName : DukeWeiTest
 * @Description : 三级节点树形结构测试
 * @Author : DukeWei
 * @Date : 2021/4/25 16:48
 * @Version : 1.0
 **/
public class DukeWeiTest {

    public static List<NodeEntity> getNodeEntityList() {
        List<NodeEntity> list = new ArrayList<>();
        list.add(new NodeEntity(1L, null, null));
        list.add(new NodeEntity(2L, 1L, 1L));
        list.add(new NodeEntity(3L, 1L, 1L));
        list.add(new NodeEntity(4L, 1L, 2L));
        list.add(new NodeEntity(5L, 1L, 2L));
        list.add(new NodeEntity(6L, 1L, 3L));
        list.add(new NodeEntity(7L, 1L, 3L));
        list.add(new NodeEntity(8L, null, null));
        list.add(new NodeEntity(9L, 8L, 8L));
        list.add(new NodeEntity(10L, 8L, 8L));
        list.add(new NodeEntity(11L, 8L, 8L));

        return list;
    }

    public static void main(String[] args) {
        List<NodeEntity> nodeEntityList = getNodeEntityList();
        Map<Long, List<NodeEntity>> collect = nodeEntityList.stream().collect(Collectors.groupingBy(NodeEntity::getId));
        nodeEntityList.forEach(e -> {
            if (e.getParentId() != null && collect.containsKey(e.getParentId())) {
                List<NodeEntity> nodeEntityList1 = collect.get(e.getParentId()).get(0).getNodeEntityList();
                nodeEntityList1.add(e);
                collect.get(e.getParentId()).get(0).setNodeEntityList(nodeEntityList1);
            }
        });

        List<NodeEntity> nodeEntities = nodeEntityList.stream().filter(e -> e.getTopParentId() == null).collect(Collectors.toList());
        for (NodeEntity nodeEntity : nodeEntities) {
            System.out.println(nodeEntity);
        }
    }
}
