package net.mov51.periderm;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.matcher.NodeMatcher;
import net.luckperms.api.node.types.MetaNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Logger;

public class AspenLuckPermsHelper {

    private static LuckPerms LPapi;

    private final String topLevelMetaKey;

    public AspenLuckPermsHelper(Logger logger,String topLevelMetaKey){
        this.topLevelMetaKey = topLevelMetaKey;
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LPapi = provider.getProvider();
            logger.info("LuckPerms dependency loaded!");
        }
    }

    public LuckPerms getLPapi() {
        return LPapi;
    }

    public String getTopLevelMetaKey(){
        return this.topLevelMetaKey + "_";
    }

    public String getMetaValue(Player p, AspenMetaKey aspenMetaKey){
        // obtain CachedMetaData - the easiest way is via the PlayerAdapter
        // of course, you can get it via a User too if the player is offline.
        CachedMetaData metaData = LPapi.getPlayerAdapter(Player.class).getMetaData(p);

        // query & parse the meta value
        return metaData.getMetaValue(this.getTopLevelMetaKey() + aspenMetaKey.getKey());
    }

    public boolean hasMetaValue(Player p, AspenMetaKey aspenMetaKey){
        User user = LPapi.getPlayerAdapter(Player.class).getUser(p);

        // query & parse the meta value
        return user.resolveInheritedNodes(NodeType.META, user.getQueryOptions())
                .stream().anyMatch(NodeMatcher.metaKey(aspenMetaKey.getKey()));
    }

    public void clearMetaValue(Player p, AspenMetaKey aspenMetaKey){
        // obtain a User instance (by any means! see above for other ways)
        User user = LPapi.getPlayerAdapter(Player.class).getUser(p);

        // clear any existing meta nodes with the same key - we want it GONE!
        user.data().clear(NodeMatcher.metaKey(this.getTopLevelMetaKey() + aspenMetaKey.getKey()));

        // save!
        LPapi.getUserManager().saveUser(user);
    }

    public void setMetaValue(Player p, AspenMetaKey aspenMetaKey, String value){
        // obtain a User instance (by any means! see above for other ways)
        User user = LPapi.getPlayerAdapter(Player.class).getUser(p);

        // create a new MetaNode holding the level value
        // of course, this can have context/expiry/etc. too!
        MetaNode node = MetaNode.builder(this.getTopLevelMetaKey() + aspenMetaKey.getKey(), value).build();

        // clear any existing meta nodes with the same key - we want to override
        user.data().clear(NodeMatcher.metaKey(this.getTopLevelMetaKey() + aspenMetaKey.getKey()));
        // add the new node
        user.data().add(node);

        // save!
        LPapi.getUserManager().saveUser(user);
    }

}
