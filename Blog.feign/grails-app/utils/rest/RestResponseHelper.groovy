package rest

import grails.validation.Validateable


trait RestResponseHelper {
    static namespace = "v1"
    static responseFormats = ['json', 'xml']

    public void respondSuccess() {
        respond statusCode: 200, status: "SUCCESS"
    }

    public void respondSuccess(Object responseModel) {
        respond statusCode: 200, status: "SUCCESS", data: responseModel
    }
}