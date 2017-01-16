package net.minecraftforge.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NotificationModUpdateScreen extends GuiScreen
{

    private static final ResourceLocation VERSION_CHECK_ICONS = new ResourceLocation("forge", "textures/gui/version_check_icons.png");

    private final GuiButton modButton;
    private Status showNotification = null;
    private boolean hasCheckedForUpdates = false;

    public NotificationModUpdateScreen(GuiButton modButton)
    {
        this.modButton = modButton;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui()
    {
        if (!hasCheckedForUpdates)
        {
            if (modButton != null)
            {
                for (ModContainer mod : Loader.instance().getModList())
                {
                    Status status = ForgeVersion.getResult(mod).status;
                    if (status == Status.OUTDATED || status == Status.BETA_OUTDATED)
                    {
                        // TODO: Needs better visualization, maybe stacked icons
                        // drawn in a terrace-like pattern?
                        showNotification = Status.OUTDATED;
                    }
                }
            }
            hasCheckedForUpdates = true;
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        if (showNotification == null || !showNotification.shouldDraw() || ForgeModContainer.disableVersionCheck)
        {
            return;
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(VERSION_CHECK_ICONS);
        GlStateManager.color(1, 1, 1, 1);
        GlStateManager.pushMatrix();

        int x = modButton.xPosition;
        int y = modButton.yPosition;
        int w = modButton.width;
        int h = modButton.height;

        drawModalRectWithCustomSizedTexture(x + w - (h / 2 + 4), y + (h / 2 - 4), showNotification.getSheetOffset() * 8, (showNotification.isAnimated() && ((System.currentTimeMillis() / 800 & 1) == 1)) ? 8 : 0, 8, 8, 64, 16);
        GlStateManager.popMatrix();
    }

    public static NotificationModUpdateScreen init(GuiMainMenu guiMainMenu, GuiButton modButton)
    {
        NotificationModUpdateScreen notificationModUpdateScreen = new NotificationModUpdateScreen(modButton);
        notificationModUpdateScreen.setGuiSize(guiMainMenu.width, guiMainMenu.height);
        notificationModUpdateScreen.initGui();
        return notificationModUpdateScreen;
    }

}