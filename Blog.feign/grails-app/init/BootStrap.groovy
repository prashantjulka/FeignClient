import Blog.Region

class BootStrap {

    def init = { servletContext ->
        bootstrap()
    }
    def destroy = {
    }

    void bootstrap() {
        (1..10).each { count ->
            new Region(
                    regionName: "Israel-$count",
                    creationDate: new Date() - count,
            ).save(flush: true)
        }
    }
}
