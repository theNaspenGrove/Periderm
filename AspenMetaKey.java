package net.mov51.periderm.luckPerms;

public class AspenMetaKey {

    String topLevelKey;

    private final String key;

    public AspenMetaKey(String topLevelKey, String key){
        this.key = key;
        this.topLevelKey = topLevelKey;
    }

    public String getKey(){
        return this.key;
    }


}
