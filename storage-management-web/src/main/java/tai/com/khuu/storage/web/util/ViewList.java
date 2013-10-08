package tai.com.khuu.storage.web.util;

public enum ViewList {
USER_CREATE_RESULT("userCreateResult"),CREATE_USER("createUser");
private String viewName;

public String getViewName() {
    return viewName;
}
private ViewList(String viewName){
    this.viewName=viewName;
}

}
