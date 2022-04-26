/*
 * The purpose of this class is to model a television 
 * Renato Chavez - 04/26/2022
 */
public class Television {
	private String manufacturer; // manufacturer of the tv
	private int screenSize; // the size of the tv
	private boolean powerOn; // whether the tv is on or off
	private int volume; // volume of the tv
	private int channel; // channel on the tv
	
	public Television() {
		
	}
	
	// Television constructor to set the manufacturer, screen size, power off, volume to 20, and channel to 2
	public Television(String manufacturer, int screenSize) {
		this.manufacturer = manufacturer;
		this.screenSize = screenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/**
	 * Sets the channel
	 * @param channel number 
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	/**
	 * Sets the power to on
	 */
	public void power() {
		this.powerOn = true;
	}
	
	/**
	 * Increases the volume by 1
	 */
	void increaseVolume() {
		if(volume != 100) {
			volume++;
		}
	}
	
	/**
	 * Decreases the volume by 1
	 */
	void decreaseVolume() {
		if(volume != 0) {
			volume--;
		}
	}
	
	/**
	 * Returns the channel number
	 * @return channel number
	 */
	public int getChannel() {
		return channel;
	}
	
	/**
	 * Returns the volume
	 * @return volume 
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Returns the manufacturer brand name
	 * @return name of the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Returns the size of the screen
	 * @return size of the screen
	 */
	public int getScreenSize() {
		return screenSize;
	}
}
