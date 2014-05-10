package net.GunWarOnline_server.plugin.Damage_changer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;


/**
 *  Damage_Changerメインクラス
 * @author kojima1021 and keepoff07
 */
public class Main extends JavaPlugin implements Listener{
    //インスタンス
    private static Main instance;
    /**
     * メインクラスを取得します
     * @return instance
     */
    public static Main getInstance(){
        return instance;
    }
    //Plugin開始時
    @Override
    public void onEnable() {
        //初期設定完了;
        //リスナー登録
        getServer().getPluginManager().registerEvents(this, this);
        //インスタンス設定
        instance = this;
        //コマンド
        //Config
        this.saveDefaultConfig();
        if (Main.this.getConfig().getString("enable") == "false") {
            getServer().getPluginManager().disablePlugins();
            getLogger().info("Configを読み取りました。");
		}else if (Main.this.getConfig().getString("enable") == "true"){
	        getLogger().info("Configを読み取りました。");
		}else {
	        getLogger().info("Configを読み取りました。");
			getLogger().info("Configでの設定で間違えてる場所があります");
			getLogger().info("1行目のenableを true か false に設定してください");
			getLogger().info("サーバーを停止します。");
			getServer().shutdown();
		}
    }
	@EventHandler
    public void Damage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			 Player p = (Player)e.getDamager();
			String hand = p.getItemInHand().getType().toString();
			String name = p.getItemInHand().getItemMeta().getDisplayName();
			String config = hand +"."+ name;
				if (!Main.this.getConfig().contains(config)) {
					return;
				}else {
					Double damage = Main.this.getConfig().getDouble(config);
					e.setDamage(damage);
				}
			}
		}
    //Pluginun終了時
    @Override
    public void onDisable() {
        if (Main.this.getConfig().getString("enable") != "true") {

        }else {
            getLogger().info("プラグインを正常に終了しました。");
		}
    }
}