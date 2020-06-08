from kivy.clock import Clock
from kivy.app import App

from kivymd.uix.button import MDFillRoundFlatIconButton


class WelcomeButton(MDFillRoundFlatIconButton):
    """Simple buttons"""

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        Clock.schedule_once(self._change_color)
        self.elevation_normal = 10
        self.md_bg_color = App.get_running_app().theme_cls.primary_color
        self.md_border_color: App.get_running_app().theme_cls.primary_color
        # self.pos_hint = {'center_x': 0.5}

    def _change_color(self, _):
        """Workaround to access children in this kivymd widget"""