package com.shopping.shopping_protal_web.tools;


import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.shopping.shopping_protal_service.service.Jpaservice;
import com.shopping.shopping_protal_web.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component("bbb")
public class AlbumViewTools {

    @Autowired
    Jpaservice ssss;

    public List<Accessory> query_album(String id){
        List list = new ArrayList();
        if ((id != null) && (!id.equals(""))){
            Map<String,Object> albumId = new HashMap<String, Object>();
            albumId.put("albumId",CommonUtils.null2Long(id));
            list = ssss.getAccessoryList(albumId);
        }else{
            Map<String,Object> albumId = new HashMap<String, Object>();
            albumId.put("albumId",CommonUtils.null2Long(id));
            list = ssss.getAccessoryList(albumId);
        }

        return list;
    }
}




