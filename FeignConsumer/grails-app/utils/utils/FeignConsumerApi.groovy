package utils

import co.RegionCO
import feign.Headers
import feign.Param
import feign.RequestLine
import org.springframework.web.bind.annotation.RequestBody


public interface FeignConsumerApi {
    @RequestLine("POST region/createRegion")
    @Headers("Content-Type: application/json")
    RegionCO addRegion(@RequestBody RegionCO regionCO)

    @RequestLine("GET region/getRegion/{id}")
    @Headers("Content-Type: application/json")
    RegionCO getRegion(@Param("id") Long id);

    @RequestLine("PUT")
    @Headers("Content-Type: application/json")
    RegionCO updateRegion(@RequestBody RegionCO regionCO)
}