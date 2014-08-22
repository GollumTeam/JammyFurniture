package net.minecraft.client.gui.mco;

import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.mco.Backup;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.resources.I18n;

class GuiScreenBackupRestoreTask extends TaskLongRunning
{
    /** The backup being restored */
    private final Backup theBackup;

    /** The screen running this task */
    final GuiScreenBackup theBackupScreen;

    private GuiScreenBackupRestoreTask(GuiScreenBackup par1GuiScreenBackup, Backup par2Backup)
    {
        this.theBackupScreen = par1GuiScreenBackup;
        this.theBackup = par2Backup;
    }

    public void run()
    {
        this.setMessage(I18n.getString("mco.backup.restoring"));

        try
        {
            McoClient var1 = new McoClient(this.getMinecraft().getSession());
            var1.func_111235_c(GuiScreenBackup.func_110367_b(this.theBackupScreen), this.theBackup.field_110727_a);

            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException var3)
            {
                Thread.currentThread().interrupt();
            }

            this.getMinecraft().displayGuiScreen(GuiScreenBackup.func_130031_d(this.theBackupScreen));
        }
        catch (ExceptionMcoService var4)
        {
            GuiScreenBackup.func_130035_e(this.theBackupScreen).getLogAgent().logSevere(var4.toString());
            this.setFailedMessage(var4.toString());
        }
        catch (Exception var5)
        {
            this.setFailedMessage(var5.getLocalizedMessage());
        }
    }

    GuiScreenBackupRestoreTask(GuiScreenBackup par1GuiScreenBackup, Backup par2Backup, GuiScreenBackupDownloadThread par3GuiScreenBackupDownloadThread)
    {
        this(par1GuiScreenBackup, par2Backup);
    }
}
