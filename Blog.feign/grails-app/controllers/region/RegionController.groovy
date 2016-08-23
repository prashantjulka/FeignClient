package region

import Blog.Region
import CO.RegionCO
import rest.RestResponseHelper

class RegionController implements RestResponseHelper {
    static allowedMethods = [getRegion   : 'GET',
                             createRegion: 'POST',
                             updateRegion: 'PUT'
    ]

    def getRegion(Long id) {
        respond Region.get(id)
    }

    def createRegion(RegionCO regionCO) {
        println "*******************Create********************"
        println "Region Details: ${regionCO.regionName}"
        println "---------------------------------------------"
        Region region = new Region()
        bindData(region, regionCO)
        region.save(flush: true)
        regionCO.regionId = region.id
        regionCO.status = "Region created Successfully!"
        respond regionCO
    }

    def updateRegion(RegionCO regionCO) {
        Region region = Region.get(regionCO.regionId as Long)
        if (region) {
            region.regionName = regionCO.regionName
            region.save(flush: true)
            regionCO.status = "Region Updated Successfully!"
        } else {
            regionCO.status = "Region not found!"
        }
        respondSuccess(regionCO)
    }
}
