# Kivy imports
from kivy.uix.screenmanager import Screen
from kivy.uix.anchorlayout import AnchorLayout
from kivy.app import App
from kivy.metrics import dp
from kivy.clock import Clock
from kivy.utils import platform

# kivymd imports
from kivymd.uix.button import MDFloatingActionButton
from kivymd.uix.card import MDCard
from kivymd.uix.label import MDLabel
from kivymd.uix.textfield import MDTextFieldRound

# project imports
from ui.widgets.nav_drawer import MyNavigationLayout
import os

class PaintBallScreen(Screen):
    def __init__(self, **kwargs):
        super(PaintBallScreen, self).__init__(name=kwargs.get('name'))

        self.ui_layout()

    def ui_layout(self):

        record_button_anchor = AnchorLayout(anchor_x='center', anchor_y='bottom',
                                            padding=[dp(25), dp(25), dp(25), dp(25)])


        self.record_button = MDFloatingActionButton(icon='record', size=[dp(56), dp(56)])
        self.record_button.md_bg_color = App.get_running_app().theme_cls.primary_color
        self.record_button.text_color = [1, 1, 1, 1]

        if platform not in ['ios', 'android']:
            self.record_button.bind(on_press=lambda x: self.decode_audio())


        record_button_anchor.add_widget(self.record_button)

        decode_card = MDCard(padding=dp(24), spacing=dp(24), orientation='vertical',
                             size_hint_x=0.85, size_hint_y=0.7,
                             pos_hint={'top': 0.85, 'center_x': 0.5})
        decode_label = MDLabel(text='Decode Morse Code Audio', font_style='Body1', halign='center',
                               size_hint=(1, 0.5))
        decode_label.theme_text_color = 'Custom'
        decode_label.text_color = [1, 1, 1, 1]
        decode_card.add_widget(decode_label)


        decode_text = 'Here are the rules for this game'
        self.decode_output_label = MDLabel(text=decode_text, font_style='Body1',
                                           halign='center', size_hint=(1, 0.5))
        self.decode_output_label.theme_text_color = 'Custom'
        self.decode_output_label.text_color = [1, 1, 1, 1]

        # decode_card.add_widget(self.decode_input)
        decode_card.md_bg_color = App.get_running_app().theme_cls.accent_color
        decode_card.elevation = 15

        self.add_widget(decode_card)
        self.add_widget(record_button_anchor)

        # Nav Bar
        self.nav_bar = MyNavigationLayout()
        self.nav_bar_anchor = AnchorLayout(anchor_x='center', anchor_y='top')
        self.nav_bar_anchor.add_widget(self.nav_bar)
        self.add_widget(self.nav_bar_anchor)

    def decode_audio(self):

        # add this line - os.system('java -jar ./jar/<filename>.jar')
        os.system('java -jar ./jar/PAINTBALL.jar')

    def return_home(self):
        self.manager.current = 'welcome'
