from kivy.properties import ObjectProperty, ListProperty
from kivy.uix.screenmanager import Screen
from kivy.clock import Clock
from kivy.uix.anchorlayout import AnchorLayout
from kivy.lang import Builder
from kivy.app import App

# Project imports
from ui.widgets.nav_drawer import MyNavigationLayout


Builder.load_string("""
#:import MDCard kivymd.uix.card
#:import MDToolbar kivymd.uix.toolbar
#:import MDRectangleFlatIconButton kivymd.uix.button
#:import MDLabel kivymd.uix.label
#:import WelcomeButton ui.widgets.welcome_button

<WelcomeButton>
    elevation_normal: 10
    md_bg_color: app.theme_cls.primary_color
    md_border_color: app.theme_cls.primary_color

<WelcomeScreen>
    canvas.before:
        Rectangle:
            pos: self.pos
            size: self.size
            source: 'ui/img/games.jpg'
            tex_coords: root.tex_coords

    FloatLayout:
        size_hint: .8, .8
        pos_hint: {'center_x': 0.5, 'center_y': .5}
        canvas.before:
            Color:
                rgba:  [1,1,1,0]
            RoundedRectangle:
                size: self.size
                pos: self.pos
                radius: [dp(10)]

        BoxLayout:
            size_hint: .8, .8
            orientation: 'vertical'
            pos_hint: {'center_x': 0.5, 'center_y': .5}

            Image:
                source: 'ui/img/arcade.png'
                size_hint_y: 1
                allow_stretch: True

            Widget:
                size_hint_y: .1
                
        
                    
            GridLayout:
                cols: 1
                spacing : dp(18)

                WelcomeButton:
                    text: 'Snakes and Ladders'
                    icon: 'gamepad'
                    size_hint_x : 1
                    on_press:
                        root.manager.current = 'snakes'
        
                WelcomeButton:
                    text: 'Tic-Tac-Toe'
                    size_hint_x: 1
                    icon: 'table-large'
                    on_press:
                        root.manager.current = 'tic'

                WelcomeButton:
                    text: 'Battleship'
                    icon: 'water'
                    size_hint_x: 1
                    on_press:
                        root.manager.current = 'battleship'

                WelcomeButton:
                    text: 'Paintball'
                    icon: 'flash'
                    size_hint_x: 1
                    on_press:
                        root.manager.current = 'paintball'

                WelcomeButton:
                    text: 'Ships'
                    icon: 'mouse'
                    size_hint_x: 1
                    on_press:
                        root.manager.current = 'ships'


""")


class WelcomeScreen(Screen):
    texture = ObjectProperty(None)
    tex_coords = ListProperty([0, 0, 1, 0, 1, 1, 0, 1])

    def __init__(self, **kwargs):
        super(WelcomeScreen, self).__init__(name=kwargs.get('name'))
        self.util = kwargs.get('util')
        self.nav_bar = MyNavigationLayout()
        self.nav_bar.toolbar.text_color = App.get_running_app().theme_cls.primary_color
        self.nav_bar.toolbar.md_bg_color = 0, 0, 0, 0
        self.nav_bar_anchor = AnchorLayout(anchor_x='center', anchor_y='top')
        self.nav_bar_anchor.add_widget(self.nav_bar)
        self.add_widget(self.nav_bar_anchor)

        Clock.schedule_once(self.texture_init, 0)
        Clock.schedule_interval(self.scroll_texture, 1 / 60.)

    def texture_init(self, *args):
        self.canvas.before.children[-1].texture.wrap = 'repeat'

    def scroll_texture(self, dt):
        for i in range(0, 8, 2):
            self.tex_coords[i] += dt / 3.
