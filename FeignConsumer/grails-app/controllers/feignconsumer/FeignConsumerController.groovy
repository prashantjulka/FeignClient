package feignconsumer

import co.RegionCO
import org.springframework.beans.factory.annotation.Autowired
import utils.FeignConsumerApi

class FeignConsumerController {
    @Autowired
    FeignConsumerApi feignConsumerApi

    def getRegionFeign(Long id) {
        render feignConsumerApi.getRegion(id).regionName
    }

    def createRegionFeign(RegionCO regionCO) {
        println "---->>${regionCO.dump()}=============="
        render feignConsumerApi.addRegion(regionCO).regionId
    }
}
