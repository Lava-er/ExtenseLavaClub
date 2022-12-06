package club.lava_er.extenselavaclub;

import club.lava_er.extenselavaclub.items.LavaSword;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class ExtenseLavaClub extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            System.out.println("DISABLED");
        }

        NamespacedKey categoryId = new NamespacedKey(this, "lava_club_category");
        CustomItemStack categoryItem = new CustomItemStack(Material.LAVA_BUCKET, "&4Our very cool Category");
        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        SlimefunItemStack itemStack = new SlimefunItemStack("A_SPECIAL_LAVA_BUCKET", Material.LAVA_BUCKET, "&a一个特别的岩浆桶", "", "&7热气腾腾...");
        ItemStack[] recipe = {
                new ItemStack(Material.DIAMOND,16),    null,                               new ItemStack(Material.BLAZE_POWDER,64),
                null,                                           SlimefunItems.CARBONADO,    null,
                new ItemStack(Material.BLAZE_POWDER,32),    null,                               new ItemStack(Material.DIAMOND,16)
        };

        SlimefunItem sfItem = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        sfItem.register(this);

        SlimefunItemStack LavaSword = new SlimefunItemStack("LAVA_SWORD", Material.GOLDEN_SWORD, "&a岩浆之剑", "", "&7右键有惊喜");
        ItemStack[] LSrecipe = {
                null,    new ItemStack(Material.BLAZE_POWDER,32),     null,
                null,     new ItemStack(Material.BLAZE_POWDER,32),    null,
                null ,    new ItemStack(Material.BLAZE_ROD,16),    null
        };

        LavaSword LSItem = new LavaSword(itemGroup, LavaSword, RecipeType.ENHANCED_CRAFTING_TABLE, LSrecipe);
        LSItem.register(this);

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */
        //ItemStack itemGroupItem = new CustomItemStack(Material.LAVA_BUCKET, "&4Lava Category", "Items from LavaClub", "&a> Click to open");

        // Give your Category a unique id.
        //NamespacedKey itemGroupId = new NamespacedKey(this, "lava_club_category");
        //ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */
        //SlimefunItemStack slimefunItem = new SlimefunItemStack("COOL_DIAMOND", Material.DIAMOND, "&4Cool Diamond", "&c+20% Coolness");

        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */
        //ItemStack[] recipe = { new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.DIAMOND), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD) };

        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
        //SlimefunItem item = new SlimefunItem(itemGroup, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        //item.register(this);


    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
