package ru.job4j.tracker;

public class Item {
    private String id;
    private  String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.created = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreated() {
        return  this.created;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("ID: ").append(this.getId());
        text.append(" name: ").append(this.getName());
        text.append(" description: ").append(this.getDesc());
        return text.toString();
    }
}
