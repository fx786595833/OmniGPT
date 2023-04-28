package cn.lanehub.ai.core.search.model;

public enum SortType {
    DEFAULT("default", "综合考虑"),
    TIME_DESC("time_desc", "时间倒排"),
    HOT_DESC("hot_desc", "热度倒排");

    private final String name;
    private final String description;

    SortType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static SortType fromName(String name) {
        for (SortType sortType : SortType.values()) {
            if (sortType.getName().equals(name)) {
                return sortType;
            }
        }
        throw new IllegalArgumentException("No enum constant " + SortType.class.getName() + "." + name);
    }
}

