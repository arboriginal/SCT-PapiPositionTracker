# SCT-PapiPositionTracker

This is a tracker addon for [SimpleCompass](https://www.spigotmc.org/resources/simplecompass.63140/).
It allows to track positions defined using [PlaholderAPI placeholders](https://www.spigotmc.org/wiki/placeholderapi-placeholders/).

**Notes:**
This tracker addon is an idea of [Shano_dekono](https://www.spigotmc.org/members/shano_dekono.529024/).
Here is how he describes its usage:
> You can use x & y placeholders to locate coordinates from different plugins
> and MvdwPlaceholderAPI x and y placeholders if you have one of mvdw's plugins
> aswell as MvdwPlaceholderAPI and PlaceholderAPI. You can then combine the Mvdw
> Placeholders and PlaceholderAPI placeholders like in the example below so that
> you have more x & y placeholders to play with. Enjoy **(quote from [plugin discussion thread](https://www.spigotmc.org/threads/simplecompass.351093/page-6#post-3313938))**

## How to install

- Drop the [jar file](https://github.com/arboriginal/SCT-PapiPositionTracker/releases) into your `plugins/SimpleCompass/trackers` folder
- Restart your server.

**Notes:**

- If `PlaholderAPI` plugin is not installed, this tracker will not load
- Configured positions may require some PlaceholderAPI expansions. It's up to you to install expansions you need.
- If PlaceholderAPI cannot parse a configured position coords, this one will not work.

## Configuration

Edit the file `plugins/SimpleCompass/trackers/PapiPositionTracker.yml` (automatically created the first time the tracker is loaded).

Read [settings.yml](https://github.com/arboriginal/SCT-PapiPositionTracker/blob/master/src/settings.yml) to have a look on available parameters.

## Permissions

- To use this tracker, players must have:
    - **scompass.use**
    - **scompass.track**
    - **scompass.track.PAPI_POSITION** (or **scompass.track.***)
- All named positions in `PapiPositionTracker.yml` use dynamic permissions:
    - **scompass.track.PAPI_POSITION.defined.`<name>`**
    - **scompass.track.PAPI_POSITION.defined.arboriginal** for example to track the position "arboriginal"
- To have access to all named positions (without **scompass.track.PAPI_POSITION.defined.<name>** for each), players need:
    - **scompass.track.PAPI_POSITION.defined.***
